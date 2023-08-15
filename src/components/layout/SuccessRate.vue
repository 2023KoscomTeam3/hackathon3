<template>
  <div class="progress-container">
    <div id="hisTitle">
      <h2>성공률</h2>
    </div>

    <Progress strokeColor="#ED6C1D" :value="20" >
      <template v-slot:footer>
        <b>예측성공률 {{ mystock }} %</b>
      </template>
    </Progress>
  </div>
</template>

<script>
import Progress from "easy-circular-progress";
export default {
  name: "app",
  components: {
    Progress,
  },
  data() {
    return {
      mystock: 0, // 초기값
    };
  },
  created() {
    console.log("1.sucessful");
    this.$axios
      .get("http://3.38.94.77/api/mypage/success-rate" + "?memberId=1")
      .then((res) => {
        this.mystock = res.data.successRate;
        console.log(this.mystock);
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style scoped>
.circle-progress {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

.progress-container {
  padding-top: 10px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

.progress-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 100px;
}

.progress-bar {
  width: 100%;
}

#hisTitle {
  margin-bottom: 50px;
}

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100vh;
  color: #fff;
  background: #3e423a;
  display: flex;
  justify-content: center;
  align-items: center;
}
body {
  margin: 0;
  padding: 0;
}
</style>
