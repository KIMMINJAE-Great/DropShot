<template>
<!--  <h3>{{ content }}</h3>-->
  <div class="communitywrite container card my-5">
   <form>
  <div class="mb-3 ">
    <label for="exampleFormControlInput1" class="form-label"></label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="제목">
  </div>
  <div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label"></label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="15" placeholder="본문" style="resize: none"></textarea>
  </div>
     <div class="mb-3">
       <label for="formFileSm" class="form-label"></label>
       <input class="form-control form-control-sm" id="formFileSm" type="file">
     </div>
     <span><button class="btn btn-color px-5 mb-2 mt-2 w-100 bg-success text-white">등록</button></span>
   </form>
  </div>
</template>

<script>
import UserService from "@/services/user.service";
import router from "@/router";
// import {createRouter as $router} from "vue-router/dist/vue-router.mjs";

export default {
  name: "CommunityWrite",
  data() {
    return {
      content: "",
    };
  },
  mounted() {
    UserService.getWritePage().then(
        (response) => {
          this.content = response.data;
        },
        (error) => {
          this.content =
              (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
              error.message ||
              error.toString();
          router.push("/login")
          alert("로그인이 필요한 서비스입니다.")
        },
        // $router.push({path:"/communitywrite"})
    ).catch(()=>{

    })

  }
}
</script>

<style scoped>
.communitywrite{
  width:700px;

}
.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>