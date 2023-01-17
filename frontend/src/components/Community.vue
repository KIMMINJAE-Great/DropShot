<template>
  <div class="container">
    <br>
    <router-link to="/communitywrite" class="btn btn-outline-light  bg-success" style="float:right; ">글쓰기</router-link>
<!--      <button @click="gowrite()" class="btn btn-outline-light  bg-success" style="float:right; ">글쓰기</button>-->
    <h1>커뮤니티</h1>

      <div class="card mb-4">
        <!--      <div class="card-header">-->
        <!--        <a class="btn btn-primary float-end" href="register"> &lt;!&ndash; <i class="fas fa-table me-1"></i> &ndash;&gt;-->
        <!--          <i class="fas fa-edit"></i> 글 작성-->
        <!--        </a>-->
        <!--      </div>-->
        <div class="card-body">
          <table class="table table-hover table-striped">
            <thead>
            <tr>

              <th>제목</th>
              <th>글쓴이</th>
              <th>추천수</th>
              <th>작성일</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${boards}" var="board">
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

</template>
<script>

export default {
  name: 'Community',

}
</script>
<style scoped>

</style>