<template>
  <div class="home">
    <Login />
  </div>
</template>

<script>
import Login from "../components/layout/Login.vue";

export default {
  components: {
    Login,
  },
};
</script>

<style>
@font-face {
    font-family: 'ChosunBg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@1.0/ChosunBg.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 95vh;
  width: 95vw;
  border-radius: 10px;
  background-color: #E5E3E1;
}
</style>