<template>
  <div id="hisContainer">
    <div id="hisTitle">
    </div>
    <div id="hisBox">
      <li v-for="his in dataArray" :key="his.historyId">
        <div
          id="hisTextBox"
          :class="['hisTextBox', getBackgroundColor(his.result)]"
        >
          <div id="nameDate">
            <h5>{{ his.stockName }}</h5>
            <h8>{{ his.date }}</h8>
          </div>
          <div id="results">
            <h9>실제가: {{ his.price }}</h9
            ><br />
            <h9>예측가: {{ his.predictPrice }}</h9
            ><br />
            <h9>오차: {{ his.difPrice }}</h9>
          </div>
          <div id="correct">
            <h5>{{ his.result }}</h5>
          </div>
        </div>
      </li>
    </div>
  </div>
</template>

<script>
export default {
  name: "history",
  data() {
    return {
      dataArray: [],
      //       {
      //   "history": [
      //     {
      //       "historyId": 1,
      //       "stockName": "삼성전자",
      //       "difPrice": -400,
      //       "date": "2023-08-08",
      //       "price": 67600,
      //       "predictPrice": 68000,
      //       "result": "실패"
    };
  },
  methods: {
    logHistoryData() {
      console.log(this.dataArray);
    },
    getBackgroundColor(result) {
      if (result === "성공") {
        return "orangeBackground"; // Apply orange background class
      } else if (result === "실패") {
        return "grayBackground"; // Apply gray background class
      }else if (result === "대기중") {
        return "brownBackgraound"; // Apply gray background class
      }
      return ""; // No specific background class
    },
  },
  created() {
    console.log("2.history");
    this.$axios
      .get("http://3.38.94.77/api/mypage/history" + "?memberId=2")
      .then((res) => {
        this.dataArray = res.data.history;
        console.log(res.data.history);
        // console.log(res.data.history[0].stockName);
      })
      .catch((err) => {
        console.log(err);
      });
    this.logHistoryData();
  },
};
</script>

<style scoped>
#hisContainer {
  padding-top: 10px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
#hisTitle {
  background-color: white;
}

#hisBox {
  height: 200px;
  width: 100%;
  margin-bottom: 50px;
  padding: 5px;
  display: flex;
  flex-direction: column;
  gap: 20px; /* Adjust the gap as needed */
}
#hisTextBox {
  height: 60px;
  width: 100%;
  /* margin-top: 10px;
  margin-left: 100px;
  margin-right: 100px; */
  padding: 40px;
  /* background-color: #ed6c1d; */
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 10px;
  gap: 10px; /* Adjust the gap as needed */
}
.nameDate .results {
  padding: 30px;
  margin-top: 100px;
}
.correct {
  /* Add any additional styling you need for each section */
}
li {
  list-style: none;
}
.orangeBackground {
  background-color: #F39A64;/* Apply orange background */
}

.grayBackground {
  background-color: #E5E3E1; /* Apply gray background */
}
.rownBackgraound{
  background-color: #6C757D;
}

</style>