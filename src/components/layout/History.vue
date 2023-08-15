<template>
  <div id="hisContainer">
    <div id="hisTitle">
      <h2>History</h2>
    </div>
    <div id="hisBox">
      <li v-for="his in dataArray" :key="his.historyId">
        <div id="hisTextBox">
          <h5>{{ his.stockName }}</h5>
          <div>
            <h5>{{ his.correctness }}</h5>
            <h8>{{ his.date }}</h8>
            <h5>{{ his.price }}</h5>
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

      //   history_List: [
      // {
      //       "historyId": 1,
      //       "stockName": "삼성전자",
      //       "correctness": "정답",
      //       "date": "2023-08-08"
      //        "price": 67600
      // }
      //   ],
    };
  },
  method: {
    logHistoryData() {
      console.log(this.dataArray);
    },
  },
  created() {
    console.log("2.history");
    this.$axios
      .get("http://3.38.94.77/api/mypage/history" + "?memberId=1")
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
}
#hisTextBox {
  height: 55px;
  margin-top: 10px;
  margin-left: 5px;
  margin-right: 5px;
  background-color: #e5e3e1;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 10px;
}
li {
  list-style: none;
}
</style>