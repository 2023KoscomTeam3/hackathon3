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
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f4f4f4;
}
</style>