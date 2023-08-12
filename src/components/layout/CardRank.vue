<template>
    <div>
      <div id="kospiT">
        <h1>오늘 HOT 코스피 시가총액</h1>
      </div>
      <ul>
        <li v-for="stock in stockL" v-bind:key="stock.name">
          <div id="kospiL">
            <div id="stockNameBox"> 
              <h3 v-bind:text="stock.name">{{stock.name}}</h3>
            </div>
            <div id="stockPlusBox">
              <b-button id="stockPlus" @click="plusStock">추가</b-button>
            </div>
          </div>
        </li>
      </ul>
    </div>
</template>

<script>
export default {
    name : "cardRank",
    props : {
      stockL : Array
    },
    created() {
      console.log("CardRank")
    },
    method :{
      plusStock() {
        
      }
    }
};
</script>

<style>
#cardGroup {
  height : 100%
}
#kospiT {
  background-color: blue;
  justify-content : center;
  text-align: "center";
  align-items : "center";
}
#kospiL {
  background-color: red;
  margin-top : 10px;
  display : flex;
  justify-content: flex-start;
  align-items: center;
}
#stockNameBox {
  width: 80%;
}
#stockPlusBox {
  width: 20%;
}
h1 {
  text-align: "center";
  justify-content : center;
}
ul{
  list-style:none;
}
</style>