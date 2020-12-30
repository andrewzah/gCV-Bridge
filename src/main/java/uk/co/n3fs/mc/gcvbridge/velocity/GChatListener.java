package uk.co.n3fs.mc.gcvbridge.velocity;

import com.velocitypowered.api.event.Subscribe;
import me.lucko.gchat.api.events.GChatMessageFormedEvent;
import uk.co.n3fs.mc.gcvbridge.GCVBridge;
import uk.co.n3fs.mc.gcvbridge.util.TextUtil;

public class GChatListener {
    private final GCVBridge plugin;
    public GChatListener(GCVBridge plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onGChatMessage(GChatMessageFormedEvent event) {
        final String msg = TextUtil.stripString(TextUtil.toMarkdown(event.getMessage()));

        plugin.getConfig().getOutChatChannels(plugin.getDApi())
                .forEach(textChannel -> textChannel.sendMessage(msg));
    }
}
