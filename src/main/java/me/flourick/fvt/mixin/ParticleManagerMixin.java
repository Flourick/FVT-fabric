package me.flourick.fvt.mixin;

import net.minecraft.client.particle.ParticleManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.flourick.fvt.FVT;

@Mixin(ParticleManager.class)
public class ParticleManagerMixin
{
	@Inject(method = "addBlockBreakParticles", at = @At("HEAD"), cancellable = true)
    private void disableBlockBreakParticles(CallbackInfo info)
    {
        if(FVT.OPTIONS.noBlockBreakParticles.getValueRaw()) {
			info.cancel();
		}
    }
}
