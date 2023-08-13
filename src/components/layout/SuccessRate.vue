<template>
    <div id="sucContainer">
        <div id="sucTitle">
            <h2>성공률</h2>
        </div>
        <div id="sucRateBox">

        </div>
    </div>
</template>

<script>
export default {
    name : "successRate",
    method : {

    },
    created() {

    }
};
</script>

<style>
    #sucContainer { 
        padding-top: 50px;
    }
    #sucTitle {
        background-color: greenyellow;
    }
    #sucRateBox {
        display: flex;
        align-content: center;
        height: 300px;
        width : 300px;
        background-color: blue;
        margin-bottom: 50px;
    }
</style>