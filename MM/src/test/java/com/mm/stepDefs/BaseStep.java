package com.mm.stepDefs;

import com.mm.utulities.Pages;


public class BaseStep {  // BaseStep, diğer adım (step) sınıfları tarafından genişletilecek temel adım sınıfını temsil eder.
    // Sayfa nesnelerine ve işlevlerine erişimi sağlamak için Pages sınıfından bir nesne oluşturulur.

    protected Pages pages = new Pages();

}