package com.hejinwei.majiang.api.socket.server;


import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EntranceServerHandler extends ChannelHandlerAdapter{
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception // 当客户端连上服务器的时候会触发此函数
	{
		System.out.println("clinet:" + ctx.channel().id() + " join server");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception// 当客户端断开连接的时候触发函数
	{
		System.out.println("clinet:" + ctx.channel().id() + " leave server");
		// User.onlineUser.remove(LoginDispatch.getInstance().user);
	}
	
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception//当客户端发送数据到服务器会触发此函数
    {
        /*SocketModel message = (SocketModel) msg;
        switch (message.getType()) {
        case TypeProtocol.TYPE_LOGIN:
            LoginDispatch.getInstance().dispatch(ctx, message);
            break;
        case TypeProtocol.TYPE_WIZARD:
            WizardDispatch.getInstance().dispatch(ctx, message);
            break;
        case TypeProtocol.TYPE_USER:
            UserDispatch.getInstance().dispatch(ctx, message);
            break;
        case TypeProtocol.TYPE_BATTLE:
            BattleDispatch.getInstance().dispatch(ctx, message);
        default:
            break;
        }
        /*<br>　　　　　　　　　　　　这里我先把代码注释掉，现在还没讲到
        　　　　　　　　*/
    	
    	ByteBuf buf = (ByteBuf)msg;
    	byte[] req = new byte[buf.readableBytes()];
    	buf.readBytes(req);
    	String body = new String(req, "UTF-8");
    	System.out.println(body);
    	
    	String respMsg = "hello,i'm server~~";
    	
    	ByteBuf resp = Unpooled.copiedBuffer(respMsg.getBytes(Charset.forName("UTF-8")));
    	ctx.write(resp);
    	ctx.flush();
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        //cause.printStackTrace();
    }
}
