<template>
   <div class="progress-container">
    <div id="hisTitle">
      
    </div>
    <div class="progress-wrapper">
      <Progress
        :transitionDuration="1200"
        :radius="90"
        :strokeWidth="40"
        :value="mystock"
        strokeColor="#ED6C1D"
      >
        <template v-slot:footer>
           <div class="success-text">
          <b>예측성공률 {{ mystock }} %</b>
           </div>
        </template>
      </Progress>
    </div>
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
  width: 200px; /* 원하는 너비로 조절 */
  height: 200px; /* 원하는 높이로 조절 */
}

.progress-container {
  padding-top: 10px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  flex-direction: column; /* 중요: 컨테이너를 세로로 배치 */
}

.progress-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 20px;
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
.success-text {
  text-align: center;
  margin-top: 10px; /* 원하는 여백 조절 */
}
/* #sec1 {
  justify-content: space-around;
  align-items: stretch;
  border: 5px solid #e5e3e1;
  border-radius: 10px;
} */
</style>
