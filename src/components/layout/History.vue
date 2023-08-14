<template>
    <div id="hisContainer">
        <div id="hisTitle">
            <h2>History</h2>
        </div>
        <div id="hisBox">
            <li v-for="his in this.history_List" v-bind:key="his.name">
                <div id="hisTextBox">
                    <h5>{{his.name}}</h5>
                    <div>
                        <h5>{{his.result}}</h5>
                        <h8>{{his.date}}</h8>
                    </div>
                </div>
            </li>
        </div>
    </div>
</template>

<script>
export default {
    name : "history",
    data() {
        return {
            history_List : [
                {name: "삼성전자", result: "성공", date:'2023.08.01' },
                {name: "삼성전자", result: "성공", date:'2023.08.01' },
                {name: "삼성전자", result: "성공", date:'2023.08.01' },
                {name: "삼성전자", result: "성공", date:'2023.08.01' },
            ]
        };
    },
    method : {

    },
    created() {
        
    }
};
</script>

<style scoped>
    #hisContainer { 
        padding-top: 50px;
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
    }
    #hisTitle {
        background-color: white;
    }
    #hisBox {
        height: 500px;
        width: 330px;
        margin-bottom: 50px;
        padding: 5px;
    }
    #hisTextBox {
        height: 70px;
        margin-top: 10px;
        margin-left: 5px;
        margin-right: 5px;
        background-color: #E5E3E1;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    li{
        list-style:none;
    }
</style>