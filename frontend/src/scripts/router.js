import Home from "@/pages/Home";
// import Login from "@/pages/Login";
import Introduce from "@/pages/Introduce";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import TennisBasic from "@/pages/TennisBasic";
import News from "@/pages/News";
import WorldNews from "@/pages/WorldNews";
import Community from "@/pages/Community"
import LocationCourt from "@/pages/LocationCourt";
import Signup from "@/pages/Signup";
import Login from "@/pages/Login";

const routes = [
    // 루트경로로 들어올때는 컴포넌트를 Home으로 연결
    {path: '/', component: Home},
    {path: '/introduce', component: Introduce},
    {path: '/basic', component: TennisBasic},
    {path: '/news', component: News},
    {path: '/worldnews', component: WorldNews},
    {path: '/community', component: Community},
    {path: '/locationcourt', component: LocationCourt},
    {path: '/signup', component: Signup},
    {path: '/login', component: Login},


    // {path:'/login', component: Login}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router;