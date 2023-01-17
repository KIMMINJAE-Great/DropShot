<template>
  <header class="p-3 bg-success">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <!--    <a href="/" class="navbar-brand">bezKoder</a>-->
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
            <use xlink:href="#bootstrap"/>
          </svg>
        </a>
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/">
            <iconify-icon icon="emojione-v1:tennis" width="35" height="35"></iconify-icon>
          </a></li>
          <li>
            <router-link to="/" class="nav-link px-2 text-white">
              <font-awesome-icon icon="home"/>
              홈으로
            </router-link>
          </li>
<!--          <li v-if="showAdminBoard">-->
          <li>
            <router-link to="/admin" class="nav-link px-2 text-white">Admin Board</router-link>
          </li>
          <li v-if="showModeratorBoard">
            <router-link to="/mod" class="nav-link px-2 text-white">Moderator Board</router-link>
          </li>
          <li>
            <router-link v-if="currentUser" to="/user" class="nav-link px-2 text-white">User</router-link>
          </li>
          <li>
            <router-link to="/introduce" class="nav-link px-2 text-white">홈페이지 소개</router-link>
          </li>
          <li>
            <router-link to="/tennisbasic" class="nav-link px-2 text-white">테니스 기초</router-link>
          </li>
          <li>
            <router-link to="/news" class="nav-link px-2 text-white">테니스 소식</router-link>
          </li>
          <li>
            <router-link to="worldnews" class="nav-link px-2 text-white">세계 소식</router-link>
          </li>
          <li>
            <router-link to="/community" class="nav-link px-2 text-white">커뮤니티</router-link>
          </li>
          <li>
            <router-link to="/locationcourt" class="nav-link px-2 text-white">코트위치</router-link>
          </li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark bg-white" placeholder="Search..."
                 aria-label="Search">
        </form>


        <div v-if="!currentUser" class="text-end">

          <router-link to="/login" class="btn btn-outline-light me-2">
            로그인
          </router-link>
          <router-link to="/register" class="btn btn-warning">
            회원가입
          </router-link>


        </div>

        <div v-if="currentUser">
          <!--유저네임-->
          <!--        <router-link to="/profile" class="nav-link">-->
          <!--          {{ currentUser.username }}-->
          <!--        </router-link>-->

          <a class="btn btn-outline-light me-2" @click.prevent="logOut">
            로그아웃
          </a>

        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "Header",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser['roles']) {
        return this.currentUser['roles'].includes('ROLE_ADMIN');
      }

      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser['roles']) {
        return this.currentUser['roles'].includes('ROLE_MODERATOR');
      }

      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>

</style>