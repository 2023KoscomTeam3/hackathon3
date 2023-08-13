<template>
    <div id="sucContainer">
        <div id="sucTitle">
            <h2>성공률</h2>
        </div>
        <div id="sucRateBox">
            <h1 id="per">{{this.percentage}}%</h1>
        </div>
    </div>
</template>

<script>
export default {
    name : "successRate",
    data() {
        return {
            percentage : 88
        }
    }
};
</script>

<style scoped>
    #sucContainer { 
        padding-top: 50px;
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
    }
    #sucTitle {
        background-color: white;
    }
    #sucRateBox {
        height: 300px;
        width : 300px;
        margin-bottom: 50px;
        background-color: white;
        background-image: url("../../assets/Spinner.png");
        background-repeat: no-repeat;
        background-size: cover; 
        background-position: center; 
        background-size: contain;
        display: flex;
        align-content: center;
    }
    #per {
        margin : 0 auto;
        margin-top: 125px;
    }
</style>