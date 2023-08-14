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
              <b-button id="stockPlus" @click="stockPlus">추가</b-button>
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
        console.log(this.$el)
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
@font-face {
    font-family: 'ChosunBg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@1.0/ChosunBg.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
* {
  font-family: 'ChosunBg' !important;
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
  margin-top : 10px;
  margin-right : 20px;
  display : flex;
  justify-content: flex-start;
  align-items: center;
  padding : 5px;
  border-radius: 10px;
}
#stockNameBox {
  margin-left: 5px;
  width: 85%;
  text-align: left;
}
#stockPlusBox {
  background-color: #E5E3E1;
  width: 15%;
}
h1 {
  text-align: "center";
  justify-content : center;
}
ul{
  list-style:none;
}
#stockPlus{
  background-color : #ED6C1D
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
</style>