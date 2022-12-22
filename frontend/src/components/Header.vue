<template>

  <header class="p-3 bg-success">

    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/"><iconify-icon icon="emojione-v1:tennis" width="35" height="35"></iconify-icon></a></li>
          <li><router-link to="/" class="nav-link px-2 text-white">홈으로</router-link></li>
          <li><router-link to="/introduce" class="nav-link px-2 text-white">홈페이지 소개</router-link></li>
          <li><router-link to="/basic" class="nav-link px-2 text-white">테니스 기초</router-link></li>
          <li><router-link to="/news" class="nav-link px-2 text-white">테니스 소식</router-link></li>
          <li><router-link to="worldnews" class="nav-link px-2 text-white">세계 소식</router-link></li>
          <li><router-link to="/community" class="nav-link px-2 text-white">커뮤니티</router-link></li>
          <li><router-link to="/locationcourt" class="nav-link px-2 text-white">코트위치</router-link></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark bg-white" placeholder="Search..." aria-label="Search">
        </form>

        <div class="text-end">
<!--          <button type="button" class="btn btn-outline-light me-2">로그인</button>-->
          <router-link to="/login"  class="btn btn-outline-light me-2">로그인</router-link>
          <router-link to="/signup" class="btn btn-warning">회원가입</router-link>
        </div>
      </div>
    </div>
  </header>
  <br>

</template>
<script>
export default {
  name:'Header',
  setup(){
    return{}
  }

}
</script>
<style scoped>
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.b-example-divider {
  height: 3rem;
  background-color: rgba(0, 0, 0, .1);
  border: solid rgba(0, 0, 0, .15);
  border-width: 1px 0;
  box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
  flex-shrink: 0;
  width: 1.5rem;
  height: 100vh;
}

.bi {
  vertical-align: -.125em;
  fill: currentColor;
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}
</style>