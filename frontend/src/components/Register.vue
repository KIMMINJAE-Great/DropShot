<template>
  <div class=" container">
    <h2 class="text-center text-dark mt-5">회원가입</h2>
    <div class="row">
      <div class="col-md-4 offset-md-3" style="margin: 0 auto">

        <div class="card my-5">

          <img
              id="profile-img"
              src="https://cdn.pixabay.com/photo/2020/06/29/20/37/asphalt-tennis-court-5354328_960_720.jpg"
              class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
              style="width:200px; margin:0 auto; height: 150px"
          />
          <Form @submit="handleRegister" :validation-schema="schema">
            <div v-if="!successful">
              <div class="form-group">
                <label for="username">아이디</label>
                <Field name="username" type="text" class="form-control"/>
                <ErrorMessage name="username" class="error-feedback"/>
              </div>
              <div class="form-group">
                <label for="password">비밀번호</label>
                <Field name="password" type="password" class="form-control" ref="password"/>
                <ErrorMessage name="password" class="error-feedback"/>
              </div>
              <div>
                <label for="passwordConfirm">비밀번호 재입력</label>
                <Field name="passwordConfirm" type="password" class="form-control" v-ref="passwordconfirm"/>
                <ErrorMessage name="passwordConfirm" class="error-feedback"/>
              </div>
              <div class="form-group">
                <label for="email">이메일</label>
                <Field name="email" type="email" class="form-control"/>
                <ErrorMessage name="email" class="error-feedback"/>
              </div>
              <div class="form-group">
                <label for="nickname">닉네임</label>
                <Field name="nickname" type="text" class="form-control"/>
                <ErrorMessage name="nickname" class="error-feedback"/>
              </div>
              <div class="form-group">
                <label for="birthday">생년월일</label>
                <Field name="birthday" type="text" class="form-control"/>
                <ErrorMessage name="birthday" class="error-feedback"/>
              </div>
              <br>
              <div class="text-center">
                <button class="btn btn-color px-5 mb-3 w-100 bg-success" :disabled="loading">
              <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
              ></span>
                  <span class="text-white">회원가입</span>
                </button>
              </div>
            </div>
          </Form>

          <div
              v-if="message"
              class="alert"
              :class="successful ? 'alert-success' : 'alert-danger'"
          >
            {{ message }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {Form, Field, ErrorMessage} from "vee-validate";
import * as yup from "yup";

export default {
  name: "Register",
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data() {
    const schema = yup.object().shape({

      username: yup
          .string()
          .required("아이디를 기입하여 주세요")
          .min(3, "3글자 이상 입력해 주세요")
          .max(20, "최대20자리 입니다."),
      email: yup
          .string()
          .required("이메일을 기입하여 주세요")
          .email("정확한 형식으로 기입하여 주세요! 예) dropshot@dropshot.com")
          .max(50, "최대 50자입니다."),
      password: yup
          .string()
          .required("비밀번호를 기입하여 주세요")
          .min(6, "최소 6자이상 입력해 주세요")
          .max(40, "최대 40자입니다."),
      passwordConfirm: yup
          .string().oneOf([yup.ref('password'), null],
              '비밀번호가 일치하지 않습니다.'),
      nickname: yup
          .string()
          .required("닉네임을 입력해 주세요.")
          .min(1, "최소 1자이상 입력해 주세요")
          .max(20, "최대 20자입니다."),
      birthday: yup
          .string()
          .required("생년월일을 입력해주세요 예) 20020202")
          .min(1, "최소 1자이상 입력해 주세요")
          .max(50, "최대 8자입니다."),


    });

    return {
      successful: false,
      loading: false,
      message: "",
      schema,
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleRegister(user) {
      this.message = "";
      this.successful = false;
      this.loading = true;

      this.$store.dispatch("auth/register", user).then(
          (data) => {
            this.message = data.message;
            this.successful = true;
            this.loading = false;
          },
          (error) => {
            this.message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();
            this.successful = false;
            this.loading = false;
          }
      );
    },
  },
};
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
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

.error-feedback {
  color: red;
}
</style>
