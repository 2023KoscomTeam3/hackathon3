<template>
  <div class="circle-progress">
    <div class="progress-container">
      <div id="hisTitle">
        <h2>성공률</h2>
      </div>
      <div class="progress-wrapper">
        <div class="progress">
          <div
            class="progress-bar"
            role="progressbar"
            :style="`width: ${mystock}%`"
            :aria-valuenow="mystock"
            aria-valuemin="0"
            aria-valuemax="100"
          >
            {{ mystock }}%
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      mystock: 30, // 초기값
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
  padding-top: 50px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

.progress-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.progress-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px; /* 원하는 여백 값으로 조정 */
}

.progress-bar {
}
</style>
