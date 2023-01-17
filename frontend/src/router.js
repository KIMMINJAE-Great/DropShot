import {createWebHistory, createRouter} from "vue-router";
import Home from "./components/Home.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";
import News from "@/components/News";
import tennisBasic from "@/components/TennisBasic";
import LocationCourt from "@/components/LocationCourt";
import Introduce from "@/components/Introduce";
import WorldNews from "@/components/WorldNews";
import Community from "@/components/Community";

const CommunityWrite =() => import("./components/CommunityWrite.vue")
// lazy-loaded
const Profile = () => import("./components/Profile.vue")
const BoardAdmin = () => import("./components/BoardAdmin.vue")
const BoardModerator = () => import("./components/BoardModerator.vue")
const BoardUser = () => import("./components/BoardUser.vue")

const routes = [
    {path: "/", name: "home", component: Home,},
    {path: "/home", component: Home,},
    {path: "/login", component: Login,},
    {path: "/register", component: Register,},
    {path: "/news", component: News,},
    {path: "/tennisbasic", component: tennisBasic,},
    {path: "/locationCourt", component: LocationCourt,},
    {path: "/introduce", component: Introduce,},
    {path: "/worldnews", component: WorldNews,},
    {path: "/community", component: Community,},
    {path: "/communitywrite", name: "CommunityWrite", //lazy-loaded
        component: CommunityWrite,},

    {path: "/profile", name: "profile", // lazy-loaded
        component: Profile,},
    {path: "/admin", name: "admin", // lazy-loaded
        component: BoardAdmin,
    },
    {path: "/mod", name: "moderator",
        // lazy-loaded
        component: BoardModerator,
    },
    {path: "/user", name: "user",
        // lazy-loaded
        component: BoardUser,},
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

// router.beforeEach((to, from, next) => {
//   const publicPages = ['/login', '/register', '/home'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');

//   // trying to access a restricted page + not logged in
//   // redirect to login page
//   if (authRequired && !loggedIn) {
//     next('/login');
//   } else {
//     next();
//   }
// });

export default router;