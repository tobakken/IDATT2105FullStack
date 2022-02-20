import { createRouter, createWebHistory } from "vue-router";
import Contact from "../views/Contact";
import Calculator from "../components/Calculator";
import Login from "../views/Login";

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login
  },
  {
    path: "/calculator",
    name: "Calculator",
    component: Calculator,
  },
  {
    path: "/contact",
    name: "Contact",
    component: Contact
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
