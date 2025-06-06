package at.pavlov.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class HookManager {
    private final Map<Class<? extends Hook<?>>, Hook<?>> hooks = new HashMap<>();

    /**
     * @return A defensive copy of the hook map
     */
    public @NotNull Map<Class<? extends Hook<?>>, Hook<?>> hookMap() {
        return Collections.unmodifiableMap(hooks);
    }

    public boolean isRegistered(@NotNull Class<? extends Hook<?>> type) {
        if (this.hooks.containsKey(type)) {
            return true;
        }

        for (Class<? extends Hook<?>> clazz : hooks.keySet()) {
            if (type.isAssignableFrom(clazz)) {
                return true;
            }
        }

        return false;
    }

    public <T extends Hook<?>> @Nullable T getHook(@NotNull Class<T> type) {
        Hook<?> hook = this.hooks.get(type);
        if (hook != null) {
            return type.cast(hook);
        }

        for (var clazzMap : hooks.entrySet()) {
            if (type.isAssignableFrom(clazzMap.getKey())) {
                return type.cast(clazzMap.getValue());
            }
        }

        return null;
    }

    public <C, T extends Hook<C>> void processIfPresent(@NotNull Class<T> type, Consumer<C> consumer) {
        T hook = getHook(type);
        if (hook == null || !hook.active()) {
            return;
        }

        C hookContent = hook.hook();
        if (hookContent == null) {
            return;
        }

        consumer.accept(hookContent);
    }

    /**
     * @return true if at least one hook in the manager is working
     */
    public boolean isActive() {
        return hooks.values().stream().anyMatch(Hook::active);
    }

    public void registerHook(@NotNull Hook<?> hook) {
        hook.onEnable();
        this.hooks.put(hook.getTypeClass(), hook);
    }

    public void disableHooks() {
        for (Hook<?> hook : hooks.values()) {
            if (hook.active()) {
                hook.onDisable();
            }
        }
    }
}
