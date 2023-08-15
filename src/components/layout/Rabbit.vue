<template>
  <div id="rabContainer">
    <div id="rabBox">
      <b>lv1.주린이</b>
    </div>
  </div>
</template>

<script>
export default {
  name: "rabbit",
  method: {},
  created() {},
};
</script>

<style scoped>
#rabContainer {
  padding-top: 50px;
  padding-left: 20px;
  padding-right: 20px;
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
}
#rabBox {
  display: flex;
  align-content: center;
  height: 250px;
  width: 250px;
  background-image: url("../../assets/rabbit.png");
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  margin-bottom: 50px;
}
</style>