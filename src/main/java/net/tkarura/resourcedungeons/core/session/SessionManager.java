package net.tkarura.resourcedungeons.core.session;

import java.util.HashMap;
import java.util.Map;

public final class SessionManager {

	private final Map<String, ISession> sessions = new HashMap<String, ISession>();

	public void init() {
		this.sessions.clear();
	}

	public void registerSession(ISession session) {

		// ハンドル取得
		SessionHandle handle = session.getClass().getAnnotation(SessionHandle.class);

		// SessionHandleアノテーションの有無チェック
		if (handle == null) {
			throw new IllegalArgumentException("Class Annotation Not Found. : " + session.getClass().toString());
		}

		// 名前を取得
		String name = handle.name();

		// 名前の衝突確認
		if (this.sessions.containsKey(name)) {
			throw new IllegalArgumentException("already registered. : " + session.getClass().getName());
		}

		// 登録
		this.sessions.put(name, session);

	}

	public ISession getSession(String session_name) {
		return this.sessions.get(session_name);
	}

}
