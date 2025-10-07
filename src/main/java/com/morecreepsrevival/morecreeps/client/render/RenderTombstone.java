package com.morecreepsrevival.morecreeps.client.render;

import com.morecreepsrevival.morecreeps.client.models.ModelTombstone;
import com.morecreepsrevival.morecreeps.common.entity.EntityTombstone;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderTombstone<T extends EntityTombstone> extends RenderCreepOwnable<T> {
    public RenderTombstone(RenderManager renderManager) {
        super(renderManager, new ModelTombstone(), 0.5f);
    }

    @Override
    protected boolean shouldDrawTamedStatus(T entity) {
        return false;
    }

    @Override
    protected boolean canRenderName(T entity) {
        return false;
    }

    public void doRender(@Nullable T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);

        if (entity == null || entity.getDistanceSq(renderManager.renderViewEntity) > 16) {
            return;
        }

        float f2 = 1.6f;

        float f3 = 0.01666667f * f2;

        String s = I18n.format("entity.morecreeps.tombstone.title.1", entity.getName());

        String s1 = I18n.format("entity.morecreeps.tombstone.title.2",  entity.getLevel(), entity.getDeadCreatureTypeName());

        FontRenderer fontRenderer = getFontRendererFromRenderManager();

        GlStateManager.pushMatrix();

        GlStateManager.translate((float) x, (float) y + 1.4f, (float) z);

        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);

        GlStateManager.rotate(-renderManager.playerViewY, 0.0f, 1.0f, 0.0f);

        GlStateManager.rotate(renderManager.playerViewX, 1.0f, 0.0f, 0.0f);

        GlStateManager.scale(-f3, -f3, f3);

        GlStateManager.disableLighting();

        GlStateManager.depthMask(false);

        GlStateManager.disableDepth();

        GlStateManager.enableBlend();

        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

        Tessellator tessellator = Tessellator.getInstance();

        BufferBuilder bufferBuilder = tessellator.getBuffer();

        GlStateManager.disableTexture2D();

        bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);

        int i = fontRenderer.getStringWidth(s);

        if (fontRenderer.getStringWidth(s1) > i) {
            i = fontRenderer.getStringWidth(s1);
        }

        int j = i / 2; // Half-width for centering
        bufferBuilder.pos(-j - 1, -1, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        bufferBuilder.pos(-j - 1, 8 + 10, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        bufferBuilder.pos(j + 1, 8 + 10, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        bufferBuilder.pos(j + 1, -1, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        
        GlStateManager.color(1F, 1F, 1F, 1F);
        fontRenderer.drawString(s, -fontRenderer.getStringWidth(s) / 2, 0, 0xffffff);
        fontRenderer.drawString(s1, -fontRenderer.getStringWidth(s1) / 2, 10, 0xffffff);

        GlStateManager.enableDepth();
        GlStateManager.depthMask(true);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

        GlStateManager.popMatrix();
    }
}
