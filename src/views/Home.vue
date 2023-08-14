<template>
    <div>
        <Header />
        <div>
            <div id="section1">
                <Card />
            </div>
            <div id="section2">
                <CardRank v-bind:stockL="stockList" />
            </div>
        </div>
    </div>
</template>


<script>
import Header from '../components/layout/Header.vue'
import Card from '../components/layout/Card.vue'
import CardRank from '../components/layout/CardRank.vue'
import Vue from 'vue';

export default {
    name : 'Home',
    components: {
        Header,
        Card,
        CardRank
    },
    data() {
        return {
            stockList : [
                {id:1, name : "삼성전자", logo : require("../assets/logo/samsung.png")},
                {id:2, name : "LG에너지솔루션", logo : require("../assets/logo/lg.png")},
                {id:3, name : "SK하이닉스", logo : require("../assets/logo/sk-hynix.png")},
                {id:4, name : "삼성바이오로직스", logo : require("../assets/logo/samsung.png")},
                {id:5, name : "POSCO홀딩스", logo : require("../assets/logo/posco.png")},
                {id:6, name : "LG화학", logo : require("../assets/logo/lg.png")},
                {id:7, name : "삼성SDI", logo : require("../assets/logo/samsung.png")},
                {id:8, name : "현대차", logo : require("../assets/logo/Hyundai.png")},
                {id:9, name : "NAVER", logo : require("../assets/logo/naver.png")},
                {id:10, name : "포스코퓨처엠", logo : require("../assets/logo/posco.png")},
            ],
            myStockList : [
                2,3,4
            ],
            addData : '',
            delData : ''
        };
    },
    methods : {
        getData()   {
            alert(this.input1);
        },
        setData()   {
            this.input1 = "12345"
        },
        sendAddData(data) {
            this.addData = data;
            Vue.bus.$emit('addStock',this.addData)
        }
    },
    created() {
            // console.log("startLoad")
            // this.$axios.get("http://3.38.94.77/api/main/my-stock-list/" + "?memberId=1")
            //     .then(res => {
            //         // console.log(res.data)
            //         console.log(res.data.myStockList);
            //         // this.myStockList = res.data.myStockList;
            //         // console.log(this.myStockList.length);
            //         // console.log(this.myStockList[0].name);
            //     })
            //     .catch(err =>   {
            //         console.log(err);
            //     })
            // console.log("endLoad")
            // this.myStockList.append(2)
            // console.log(this.myStockList)
            // console.log(sessionStorage.getItem("myStockList"))
    },
    mounted() {
        sessionStorage.setItem("myStockList", JSON.stringify(this.myStockList));
        console.log(sessionStorage.getItem("myStockList"))
    }
};
</script>


<style>
@font-face {
    font-family: 'ChosunBg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@1.0/ChosunBg.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#container {
    width: 100%;
    height: 100%;
    border-radius: 10px;
    background-color : red
}
#section1 {
    width: 50%;
    float: left;
    box-sizing: border-box;
    flex : 1
}
#section2 {
    width: 50%;
    float: right;
    box-sizing: border-box;
    padding : 10px;
}
</style>