<template>
    <div id="homeContainer">
        <Header />
        <div class="homeContent">
            <div class="section">
                <Card />
            </div>
            <div class="section" >
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
#homeContainer {
    width: 90vw; /* 90% of the viewport width */
    height: 95vh; /* 90% of the viewport height */
    border-radius: 10px;
    background-color : white;
    align-items: stretch; /* Stretch items to fit container width */
    border: 5px solid #E5E3E1; /* Add this line to set border properties */
}
.homeContent {
    display: flex;
    flex-wrap: wrap; /* 요소들을 줄 바꿈하여 배치 */
    justify-content: space-between; /* 요소들 간격을 최대한 늘려서 배치 */
}
.section {
    width: 50%; /* 각각의 섹션이 반씩 차지하도록 조정 */
    box-sizing: border-box;
    padding: 10px;
    margin-bottom: 20px; /* 아래 여백 추가 */
}
Card, CardRank {
    height: 100%;
}
</style>