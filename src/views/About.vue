<template>
    <div>
        <div id="aboutContainer">
            <div class="homeContent">
                <Header />
                <div id="sec1">
                    <SuccessRate />
                </div>
                <div id="sec2">
                    <History />
                </div>
                <div id="sec3">
                    <Rabbit />
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import Header from '../components/layout/Header.vue'
import SuccessRate from '../components/layout/SuccessRate.vue'
import History from '../components/layout/History.vue'
import Rabbit from '../components/layout/Rabbit.vue'

export default {
    name : 'About',
    components: {
        Header,
        SuccessRate,
        History,
        Rabbit,
    },
    data() {
        return {
            stockList : [
                {id:1, name : "삼성전자"},
                {id:2, name : "LG에너지솔루션"},
                {id:3, name : "SK하이닉스"},
                {id:4, name : "삼성바이오로직스"},
                {id:5, name : "POSCO홀딩스"},
                {id:6, name : "LG화학"},
                {id:7, name : "삼성SDI"},
                {id:8, name : "현대차"},
                {id:9, name : "NAVER"},
                {id:10, name : "포스코퓨처엠"},
            ],
        };
    },
    methods : {
        getData()   {
            alert(this.input1);
        },
        setData()   {
            this.input1 = "12345"
        }
    }
};
</script>

<style>
#aboutContainer {
    width: 90vw; /* 90% of the viewport width */
    height: 95vh; /* 90% of the viewport height */
    border-radius: 10px;
    background-color : white;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: stretch;
    border: 5px solid #E5E3E1; /* Add this line to set border properties */
}
.homeContent {
    width: 100%;
    display: flex;
    flex-wrap: wrap; /* 요소들을 줄 바꿈하여 배치 */
    justify-content: space-between; /* 요소들 간격을 최대한 늘려서 배치 */
}
#sec1 {
    width: 30%;
    box-sizing: border-box;
}
#sec2 {
    width: 40%;
    box-sizing: border-box;
}
#sec3 {
    width: 30%;
    box-sizing: border-box;
}
</style>
