<template>
  <div class="login-container">
    <img src= "../../assets/kosletter.png"/>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username" required>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" required>
      <button type="submit" >Login</button>
      <ChildComponent v-bind:username="username" />
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    login() {
      if (this.username == "cubix98@naver.com" && this.password == '1234')  {
        sessionStorage.setItem('username',JSON.stringify(this.username));
        sessionStorage.setItem('password',JSON.stringify(this.password));
        this.$router.push('../Home');
      } else  {
        alert('로그인에 실패하였습니다. 사용자 정보를 확인해주세요');
      }
    },
  },
};
</script>

<style scoped>
@font-face {
    font-family: 'ChosunBg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@1.0/ChosunBg.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.login-container {
  width: 300px;
  margin: auto;
  padding: 20px;
  border: 1px solid #F4F2EB;
  border-radius: 5px;
}
form {
  display: flex;
  flex-direction: column;
}
label {
  margin-top: 10px;
}
input {
  margin-bottom: 10px;
  padding: 5px;
  width: 100%; 
}
button {
  background-color: #ED6C1D;
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
}
</style>
