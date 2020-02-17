<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="cname"
                    label="姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="csex"
                    label="性别"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="cschool"
                    label="学校"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="clevel"
                    label="等级"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="cpower"
                    label="能力名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="cgrade"
                    label="年级"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteById(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "PageOne",
        methods: {
            edit(row) {
                this.$router.push({
                    path: '/book_update',
                    query: row,
                })
            },
            deleteById(row) {
                const _this = this;
                axios.delete("http://localhost:8081/student/" + row.id).then(function (response) {
                    if (response.status == 200) {
                        _this.$alert(row.cname + '删除成功', 'success', {
                            callback: action => {
                                window.location.reload();
                            }
                        });
                    } else {
                        _this.$alert(row.cname + '删除失败', 'failure');
                    }
                })
            },
            page(currentPage) {
                const _this = this;
                axios.get('http://localhost:8081/student/' + (currentPage - 1) + '/5').then(function (response) {
                    _this.tableData = response.data.content;
                    _this.pageSize = response.data.size;
                    _this.total = response.data.totalElements;
                })
            }
        },
        data() {
            return {
                pageSize: 1,
                total: 10,
                tableData: [
                    {
                        id: 1,
                        cname: '一方通行',
                        csex: '未知',
                        clevel: 'LV5',
                        cschool: '长点上机学园',
                        cpower: '矢量操纵',
                        cgrade: '高一',
                    },
                ]
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8081/student/0/5').then(function (response) {
                _this.tableData = response.data.content;
                _this.pageSize = response.data.size;
                _this.total = response.data.totalElements;
            })
        }
    }
</script>
