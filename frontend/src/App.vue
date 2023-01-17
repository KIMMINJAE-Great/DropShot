<template>
<Header/>
    <div class="container">
      <Router-view />
    </div>
<Footer/>

</template>

<script>

import Header from "@/components/Header";
import Footer from "@/components/Footer";
export default {
  components: {Footer, Header}
};
</script>
