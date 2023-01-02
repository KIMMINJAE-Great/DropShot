<template>
  <div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">회원가입</h2>
        <div class="card my-5">
<!-- action method 기재-->
          <form class="card-body cardbody-color p-lg-5">

            <div class="text-center">
              <img src="https://cdn.pixabay.com/photo/2020/06/29/20/37/asphalt-tennis-court-5354328_960_720.jpg"
                   class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                   width="200px" alt="profile">
            </div>

            <div class="mb-3">
              <input type="text" class="form-control" id="id" aria-describedby="emailHelp" v-model="state.form.id"
                     placeholder="아이디">
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="password" v-model="state.form.password"
                     placeholder="비밀번호">
            </div>
            <div class="mb-3">
              <input type="password" class="form-control"  v-model="state.form.passwordConfirm"
                     placeholder="비밀번호 재입력">
            </div>
            <div class="mb-3">
              <input type="text" class="form-control" id="email"  v-model="state.form.email"
                     placeholder="이메일">
            </div>
            <div class="mb-3">
              <input type="text" class="form-control" id="Username" v-model="state.form.nickname"
                     aria-describedby="emailHelp"
                     placeholder="닉네임">
            </div>
            <div class="mb-3">
              <input type="text" class="form-control" id="birthday" v-model="state.form.birthday"
                     aria-describedby="emailHelp"
                     placeholder="생년월일 ex) 20221230">
            </div>


<!--            <span class="mb-3 " style="display: inline-block; width:160px; margin-right:23px;">-->
<!--              <input type="text" id="yy" placeholder="년(4자)" aria-label="년(4자)" class="int form-control"-->
<!--                     v-model="state.form.year"-->
<!--                     maxlength="4">-->
<!--            </span>-->

<!--            <span class="mb-3" style="display: inline-block; width:160px; margin-right:22px;">-->
<!--								<span class="ps_box">-->
<!--									<select id="mm" class="form-select mb-3 month" aria-label="월" v-model="state.form.month">-->
<!--										<option value="">월</option>-->
<!--                    <option value="01">1</option>-->
<!--                    <option value="02">2</option>-->
<!--                    <option value="03">3</option>-->
<!--                    <option value="04">4</option>-->
<!--                    <option value="05">5</option>-->
<!--                    <option value="06">6</option>-->
<!--                    <option value="07">7</option>-->
<!--                    <option value="08">8</option>-->
<!--                    <option value="09">9</option>-->
<!--                    <option value="10">10</option>-->
<!--                    <option value="11">11</option>-->
<!--                    <option value="12">12</option>-->
<!--									</select>-->
<!--								</span>-->

<!--            </span>-->

<!--            <span class="mb-3" style="display: inline-block; width:160px;">-->
<!--              <input type="text" id="yy" placeholder="일" aria-label="년(4자)" class="int form-control day" maxlength="4"-->
<!--                     v-model="state.form.day">-->
<!--            </span>-->


            <!--네이버 생일 참고-->
            <!--            <div class="bir_wrap">-->
            <!--              <div class="bir_yy">-->
            <!--								<span class="ps_box">-->
            <!--									<input type="text" id="yy" placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">-->
            <!--								</span>-->
            <!--              </div>-->
            <!--              <div class="bir_mm">-->
            <!--								<span class="ps_box">-->
            <!--									<select id="mm" class="sel" aria-label="월">-->
            <!--										<option value="">월</option>-->
            <!--                    <option value="01">1</option>-->
            <!--                    <option value="02">2</option>-->
            <!--                    <option value="03">3</option>-->
            <!--                    <option value="04">4</option>-->
            <!--                    <option value="05">5</option>-->
            <!--                    <option value="06">6</option>-->
            <!--                    <option value="07">7</option>-->
            <!--                    <option value="08">8</option>-->
            <!--                    <option value="09">9</option>-->
            <!--                    <option value="10">10</option>-->
            <!--                    <option value="11">11</option>-->
            <!--                    <option value="12">12</option>-->
            <!--									</select>-->
            <!--								</span>-->
            <!--              </div>-->
            <!--              <div class=" bir_dd">-->
            <!--								<span class="ps_box">-->
            <!--									<input type="text" id="dd" placeholder="일" aria-label="일" class="int" maxlength="2">-->
            <!--									<label for="dd" class="lbl"></label>-->
            <!--								</span>-->
            <!--              </div>-->
            <!--            </div>-->

            <div class="text-center">
              <button type="button" @click="submit()" class="btn btn-color px-5 mb-5 w-100">회원가입</button>
            </div>

          </form>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import { reactive} from "vue";
import axios from "axios";
import router from "@/scripts/router";



export default {
  name: "Signup",
  setup() {

    const state = reactive({
      form: {
        id: "",
        password: "",
        email: "",
        nickname: "",
        birthday:"",

      }
    })

    const submit = () => {
      if (state.form.id == null || state.form.id == "") {
        alert("아이디를 입력 해주세요")
        return

      }if (state.form.password == "") {
        alert("비밀번호를 입력해주세요")
        return

      }if (state.form.password != state.form.passwordConfirm) {
        alert("비밀번호가 일치하지 않습니다.")
        return
      }if (state.form.email == state.form.email) {
        alert("이메일을 입력해 주세요")
        return

      }if (state.form.nickname == "") {
        alert("닉네임을 입력해주세요")
        return

      }if (state.form.birthday == "") {
        alert("생년월일을 입력해주세요")
        return

      }
      axios.post("/api/account/signup", state.form).then((res)=>{
        console.log("데이터"+res.data);
        router.push({path:"/"})
        alert(res.data+"님 회원가입이 완료되었습니다.")
      }).catch(()=>{
        if (state.form.id == null || state.form.id == "") {
          alert("아이디를 입력 해주세요")
          return

        }if (state.form.password == "") {
          alert("비밀번호를 입력해주세요")
          return

        }if (state.form.password != state.form.passwordConfirm) {
          alert("비밀번호가 일치하지 않습니다.")
          return

        }if (state.form.nickname == "") {
          alert("닉네임을 입력해주세요")
          return

        }if (state.form.birthday == "") {
          alert("생년월일을 입력해주세요")
          return

        }
          }

      )



    }


    return {state, submit}
  }

}
</script>

<style scoped>
.btn-color {
  background-color: #198754;
  color: #fff;

}

.profile-image-pic {
  height: 200px;
  width: 200px;
  object-fit: cover;
}


.cardbody-color {
  background-color: #ebf2fa;
}

a {
  text-decoration: none;
}

</style>