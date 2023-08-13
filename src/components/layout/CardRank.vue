<template>
    <div>
      <div id="kospiT">
        <h1>오늘 HOT 코스피 시가총액</h1>
      </div>
      <ul>
        <li v-for="stock in stockL" v-bind:key="stock.id">
          <div id="kospiL">
            <div id="stockNameBox"> 
              <h3 v-bind:text="stock.name">{{stock.id}}. {{stock.name}}</h3>
            </div>
            <div id="stockPlusBox">
              <b-button id="stockPlus" v-on:click="stockPlus" target="li">추가</b-button>
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
    methods : {
      stockPlus() {
        console.log('click')
        // console.log(this.$event.target)
        // console.log(this.stock.name)
      }
    },
    created() {
      console.log("CardRank")
    },
};
</script>

<style>
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
  margin-top : 10px;
  margin-right : 20px;
  display : flex;
  justify-content: flex-start;
  align-items: center;
  padding : 5px;
}
#stockNameBox {
  margin-left: 5px;
  width: 85%;
  text-align: left;
}
#stockPlusBox {
  width: 15%;
}
h1 {
  text-align: "center";
  justify-content : center;
}
ul{
  list-style:none;
}
</style>