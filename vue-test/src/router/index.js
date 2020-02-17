import Vue from 'vue'
import VueRouter from 'vue-router'
import BookManage from "../views/BookManage"
import BookAdd from "../views/BookAdd"
import Index from "../views/Index";
import BookUpdate from "../views/BookUpdate";

Vue.use(VueRouter);

const routes = [{
    path: '/',
    name: '信息管理',
    component: Index,
    show: true,
    redirect: "book_manage",
    children: [{
        path: '/book_manage',
        name: '查询信息',
        component: BookManage
    }, {
        path: '/book_add',
        name: '添加信息',
        component: BookAdd
    }, {
        path: '/book_update',
        name: '编辑信息',
        component: BookUpdate
    }
    ]
}
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router
