<template>
    <div id="rankContainer">
      <div id="kospiT">
        <h1>오늘 HOT 코스피 시가총액</h1>
      </div>
      <div id="kospiContent"> 
        <div class="kospiList">
          <ul>
            <li v-for="stock in stockL.slice(0, 5)" :key="stock.id">
              <div id="kospiL">
                <div id="stockNameBox">
                  <h7 v-bind:text="stock.name">{{ stock.id }}. {{ stock.name }}</h7>
                </div>
                <div id="stockPlusBox">
                  <b-button id="stockPlus" @click="stockPlus(stock)" :key="stock">추가</b-button>
                </div>
              </div>
            </li>
          </ul>
        </div>
        <div class="kospiList">
          <ul>
            <li v-for="stock in stockL.slice(5, 10)" :key="stock.id">
              <div id="kospiL">
                <div id="stockNameBox">
                  <h7 v-bind:text="stock.name">{{ stock.id }}. {{ stock.name }}</h7>
                </div>
                <div id="stockPlusBox">
                  <b-button id="stockPlus" @click="stockPlus(stock)" :key="stock">추가</b-button>
                </div>
              </div>
            </li>
          </ul>
        </div>

      </div>
    </div>
</template>

<script>
import Vue from 'vue';

export default {
    name : "cardRank",
    props : {
      stockL : Array
    },
    methods : {
      stockPlus(stock) {
        Vue.bus.$emit('eventA', stock);
        // this.$axios.post("http://3.38.94.77/api/main/my-stock", {
        //           "memberId" : 1,
        //           "stockId" : stock.name,
        //         })
        //         .then(res => {
        //             console.log(res.data)
        //         })
        //         .catch(err =>   {
        //             console.log(err);
        //         })
      }
    },
    created() {
      console.log("CardRank")
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
* {
  font-family: 'ChosunBg' !important;
}
#rankContainer {
  height : 100%
}
#cardGroup {
  height : 100%
}
#kospiT {
  justify-content : center;
  text-align: "center";
  align-items : "center";
}
#kospiL {
  background-color: #e5e3e1;
  margin-top : 5px;
  margin-right : 20px;
  display : flex;
  justify-content: flex-start;
  align-items: center;
  padding : 2px 2px 5px 5px;
  border-radius: 10px;
  height: 55px;
}
#stockNameBox {
  margin-left: 5px;
  width: 75%;
  text-align: left;
}
#stockPlusBox {
  background-color: #E5E3E1;
  width: 20%;
}
h1 {
  text-align: "center";
  justify-content : center;
}
ul{
  list-style:none;
}
#stockPlus{
  background-color : #ED6C1D;
  height : 30px;
  width : 50px;
  font-size: 12px;
  margin-right: 5px;
}
#all{
  background-color: #F4F2EB
}
#alls{
  background-color: #FFFFFF;
  margin: 20px ;
  padding: 10px;
  border-radius: 10px;
}
#kospiContent {
  display: flex;
}
.kospiList {
  display: flex;
  width: 100%;
  justify-content: space-between;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.kospiList ul {
  list-style: none;
  padding: 0;
  margin: 0;
  width: 100%; /* 왼쪽과 오른쪽 컨테이너의 너비 설정 */
}

.kospiList li {
  width: 100%;
  box-sizing: border-box;
  padding: 5px;
}
</style>