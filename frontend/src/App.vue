<template>
<Header/>
  <main class="container">
  <RouterView class="routerview"/>
  </main>
<Footer/>



</template>

<script>



import Header from "@/components/Header";
import Footer from "@/components/Footer";
export default {
  name: 'App',
  components: {
    Footer,
    Header


  }
}
</script>

<style>
.container .routerview{
  margin:0 auto;

}
</style>
