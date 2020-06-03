import Vue from 'vue'
import VueRouter from 'vue-router'
import Encrypt from '@/views/Encrypt.vue'
import Decrypt from '@/views/Decrypt.vue'
import About from '@/views/About.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Encrypt',
    component: Encrypt
  },
  {
    path: '/about',
    name: 'About',
    component: About
  }, {
    path: '/r/:requestId/k/:secretKey',
    name: 'Decrypt',
    component: Decrypt
  }
]

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
})

export default router
