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
              <input type="text" class="form-control" id="Username" aria-describedby="emailHelp"
                     placeholder="아이디">
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="password" placeholder="비밀번호">
            </div>
            <div class="text-center"><button type="submit" class="btn btn-color px-5 mb-5 w-100">로그인</button></div>
            <div id="emailHelp" class="form-text text-center mb-5 text-dark">회원이 아니시라면 &nbsp; <a href="#" class="text-dark fw-bold"> 회원가입</a>
            </div>
          </form>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login"
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