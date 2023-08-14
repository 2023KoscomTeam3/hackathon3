<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username" required>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" required>
      <button type="submit">Login</button>
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
      // 간단한 로그인 체크
      if (this.username === 'username' && this.password === 'password') {
        alert('Login successful!');
         //페이지 이동
       this.$router.push('../Home');
      } else {
        alert('Login failed. Please check your credentials.');
         //페이지 이동
       this.$router.push('../Home');
       
      }
    }
  }
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
  border: 1px solid #ccc;
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
}
button {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
}
</style>
