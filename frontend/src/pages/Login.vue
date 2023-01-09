<template>
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">로그인</h2>
        <div class="card my-5">

          <form class="card-body cardbody-color p-lg-5">

            <div class="text-center">
              <img src="https://cdn.pixabay.com/photo/2014/06/06/18/47/tennis-363662_960_720.jpg" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                   width="200px" alt="profile">
            </div>

            <div class="mb-3">
              <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp"
                     v-model="state.form.username" placeholder="아이디">
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="password" name="password" v-model="state.form.password" placeholder="비밀번호">
            </div>
            <div class="text-center"><button type="button" @click="submit()" class="btn btn-color px-5 mb-5 w-100">로그인</button></div>
            <div id="emailHelp" class="form-text text-center mb-5 text-dark" >
              회원이 아니시라면 &nbsp;
              <router-link to="/signup" class="text-dark fw-bold"> 회원가입</router-link>
            </div>
          </form>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";

export default {
  name: "Login",
  setup(){


    const state = reactive({
      form:{
        username:"",
        password:"",
      }
    })
    const submit = ()=>{
      if(state.form.username ==""){
        alert("아이디를 입력해 주세요")
        return
      }
      if(state.form.password ==""){
        alert("비밀번호를 입력해 주세요")
        return
      }
      // axios.post("/login", state.form).then((res) => {
      //   // store.commit('setAccount', 'res.data');
      //   console.log("데이터" + res.data);
      //   // sessionStorage.setItem("forSessionId", res.data)
      //   // router.push({path: "/"})
      //   // alert(res.data + "님 로그인이 완료되었습니다.")
      // }).catch(() => {
      //       window.alert("뭔가 잘못됨")
      //     }
      // }
// Spring으로 데이터가 Json으로 넘어가 제대로 값을 받지 못해 Content-type 을 변경
      const config = {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      };

      // axios.post("/login", state.form, config);

      axios.post("/login", state.form, config).then(()=>{
        router.push({path: "/"})
      });



    }


    return{state, submit}
  }




}
</script>

<style scoped>
.btn-color{
  background-color: #198754;
  color: #fff;

}

.profile-image-pic{
  height: 200px;
  width: 200px;
  object-fit: cover;
}



.cardbody-color{
  background-color: #ebf2fa;
}

a{
  text-decoration: none;
}
</style>
