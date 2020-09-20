//package com.qin_kai.springtest.aop;
//
//
//public aspect CriticAspect {
//    private CriticismEngine criticismEngine;
//    public CriticAspect() {
//    }
//
//    pointcut perform() : execution(* Performer.perform(..);
//
//    after() : perform() {
//        criticismEngine.criticism();
//    }
//    public void setCristicismEngine(CriticismEngine cristicismEngine) {
//        this.criticismEngine = cristicismEngine;
//    }
//}
