<template>
    <div id="hisContainer">
        <div id="hisTitle">
            <h2>History</h2>
        </div>
        <div id="hisBox">
            <li v-for="his in this.history_List" v-bind:key="his.name">
                <div id="hisTextBox">
                    <h5>{{his.name}}</h5>
                    <h5>{{his.result}}</h5>
                    <h5>{{his.date}}</h5>
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

<style>
    #hisContainer { 
        padding-top: 50px;
    }
    #hisTitle {
        background-color: white;
    }
    #hisBox {
        height: 500px;
        width : 300px;
        background-color: blue;
        margin-bottom: 50px;
    }
    #hisTextBox {
        height: 50px;
        margin-top: 5px;
        margin-left: 5px;
        margin-right: 5px;
        background-color: aqua;
        display: flex;
    }
</style>