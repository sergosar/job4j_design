package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRolenameIsUser() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("User");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsUser() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        store.add(new Role("1", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("User");
    }

    @Test
    void whenReplaceThenRolenameIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        store.replace("1", new Role("1", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Admin");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        store.replace("10", new Role("10", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("User");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsUser() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("User");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        boolean result = store.replace("1", new Role("1", "Admin"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "User"));
        boolean result = store.replace("10", new Role("10", "Admin"));
        assertThat(result).isFalse();
    }
}