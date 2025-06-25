package com.github.devguilhermeribeiiro.ResfWallet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        assertNotNull(App.getGreeting(), "app should have a greeting");
    }
}
