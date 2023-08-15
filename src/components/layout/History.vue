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
        // 4개까지만 보여준다
        this.dataArray = res.data.history
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
  width: 100%;
  padding-top: 5px;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
#hisTitle {
  background-color: white;
}
#hisBox {
  height: 330px;
  width: 100%;
  margin-bottom: 50px;
  padding: 3px;
  display: flex;
  flex-direction: column;
  overflow: scroll;
}
#hisTextBox {
  width: 100%;
  padding: 10px;
  margin-bottom: 8px;

  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 10px;
}
#nameDate {
    width: 20%;
} 
#results {
    text-align: left;
}
#correct {
    width: 20%;
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
.brownBackgraound{
  background-color: #ffe4b5;
}

</style>