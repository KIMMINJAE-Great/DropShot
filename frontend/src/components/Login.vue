<template>
  <div class=" container">
    <h2 class="text-center text-dark mt-5">로그인</h2>
    <div class="row">
      <div class="col-md-4 offset-md-3" style="margin: 0 auto">
<!--      <div class="text-center">-->
<!--        <img src="https://cdn.pixabay.com/photo/2014/06/06/18/47/tennis-363662_960_720.jpg" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"-->
<!--             width="200px" alt="profile">-->
<!--      </div>-->
        <div class="card my-5">
      <img
        id="profile-img"
        src="https://cdn.pixabay.com/photo/2014/06/06/18/47/tennis-363662_960_720.jpg"
        class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
        style="width:200px; margin:0 auto;"
      />
      <Form @submit="handleLogin" :validation-schema="schema">
        <div class="text-center">
        </div>
        <div class="mb-3">
          <label for="username">아이디</label>
          <Field name="username" type="text" class="form-control"/>
          <ErrorMessage name="username" class="error-feedback" />
        </div>
        <div class="mb-3">
          <label for="password">비밀번호</label>
          <Field name="password" type="password" class="form-control"/>
          <ErrorMessage name="password" class="error-feedback"/>
        </div>

        <div class="text-center">
          <button class="btn btn-color px-5 mb-2 w-100 bg-success" :disabled="loading">
            <span
              v-show="loading"
              class="spinner-border spinner-border-sm"
            ></span>
            <span class="text-white">로그인</span>
          </button>
        </div>

        <div class="form-group">
          <div v-if="message" class="alert alert-danger" role="alert">
            {{ message }}
          </div>
        </div>
      </Form>
          </div>
        </div>
    </div>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";

export default {
  name: "Login",
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data() {
    const schema = yup.object().shape({
      username: yup.string().required("아이디를 입력해 주세요"),
      password: yup.string().required("비밀번호를 입력해 주세요"),
    });

    return {
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
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;

      this.$store.dispatch("auth/login", user).then(
        () => {
          this.$router.push("/profile");
        },
        (error) => {
          this.loading = false;
          this.message =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
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
