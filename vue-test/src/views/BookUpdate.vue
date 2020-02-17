<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm"
             style="width: 50%">
        <el-form-item label="编号" prop="id">
            <el-input v-model="ruleForm.id" readonly></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="cname">
            <el-input v-model="ruleForm.cname"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="csex">
            <el-input v-model="ruleForm.csex"></el-input>
        </el-form-item>
        <el-form-item label="等级" prop="clevel">
            <el-input v-model="ruleForm.clevel"></el-input>
        </el-form-item>
        <el-form-item label="学校" prop="cschool">
            <el-input v-model="ruleForm.cschool"></el-input>
        </el-form-item>
        <el-form-item label="能力" prop="cpower">
            <el-input v-model="ruleForm.cpower"></el-input>
        </el-form-item>
        <el-form-item label="年级" prop="cgrade">
            <el-input v-model="ruleForm.cgrade"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: 'BookUpdate',
        data() {
            return {
                ruleForm: {
                    id: '',
                    cname: '',
                    csex: '',
                    clevel: '',
                    cschool: '',
                    cpower: '',
                    cgrade: '',
                },
                rules: {
                    cname: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                    ],
                    csex: [
                        {required: true, message: '请输入性别', trigger: 'blur'},
                    ],
                    clevel: [
                        {required: true, message: '请输入能力等级', trigger: 'blur'},
                    ],
                    cschool: [
                        {required: true, message: '请输入学校', trigger: 'blur'},
                    ],
                    cpower: [
                        {required: true, message: '请输入能力名称', trigger: 'blur'},
                    ],
                    cgrade: [
                        {required: true, message: '请输入能力等级', trigger: 'blur'},
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put('http://localhost:8081/student', _this.ruleForm).then(function (response) {
                            if (response.data == 'success') {
                                _this.$message('添加成功');
                                _this.$router.push('/book_manage')
                            } else {
                                _this.$message('添加失败');
                            }
                        });
                    } else {
                        _this.$message('添加失败');
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            this.ruleForm = this.$route.query;
        }
    }
</script>

<style scoped>

</style>
