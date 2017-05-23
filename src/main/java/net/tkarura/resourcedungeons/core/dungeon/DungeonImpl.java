package net.tkarura.resourcedungeons.core.dungeon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

/**
 * ダンジョンに関わる情報を保持する為のクラスです。
 * 
 * @author the_karura
 */
public class DungeonImpl implements IDungeon {
    
    protected final String id;
    protected File dir;
    protected String support = "1.0.0";
    protected String name = "N/A";
    protected String version = "N/A";
    protected String discription = "N/A";
    protected List<DungeonUser> authors = new ArrayList<DungeonUser>();
    protected List<DungeonUser> contributors = new ArrayList<DungeonUser>();
    
    /**
     * ダンジョンIDを指定して生成します。
     * ダンジョンIDは他のIDと被らない文字列を指定する必要があります。
     * @param id ダンジョンID
     */
    public DungeonImpl(String id) {
	Validate.notNull(id, "id is null.");
	this.id = id;
    }
    
    /**
     * ダンジョンの構造が配置されているディレクトリを設定します。
     * @param dir ダンジョン構造
     */
    public void setDirectory(File dir) {
	this.dir = dir;
    }
    
    /**
     * ダンジョンのサポートされるバージョンを設定します。
     * @param support サポートバージョン
     */
    public void setSupport(String support) {
	this.support = support;
    }
    
    /**
     * ダンジョンの名前を設定します。
     * @param name ダンジョンの名前になる文字列
     */
    public void setName(String name) {
	this.name = name != null ? name : "N/A";
    }
    
    /**
     * ダンジョンのバージョンを設定します。
     * @param version バージョン
     */
    public void setVersion(String version) {
	this.version = version != null ? version : "N/A";
    }
    
    /**
     * ダンジョンの説明を設定します。
     * @param discription ダンジョンの説明
     */
    public void setDiscription(String discription) {
	this.discription = discription;
    }
    
    /**
     * ダンジョン作成に関わった作者のユーザ情報を追加します。
     * @param user ユーザ情報
     */
    public void addAuthor(DungeonUser user) {
	this.authors.add(user);
    }
    
    /**
     * ダンジョン作成に関わった貢献者のユーザ情報を追加します。
     * @param user 貢献者
     */
    public void addContributor(DungeonUser user) {
	this.contributors.add(user);
    }
    
    @Override
    public File getDirectory() {
	return this.dir;
    }
    
    @Override
    public final String getId() {
	return this.id;
    }

    @Override
    public String getSupport() {
	return this.support;
    }
    
    @Override
    public String getName() {
	return this.name;
    }
    
    @Override
    public String getVersion() {
	return this.version;
    }

    @Override
    public String getDiscription() {
	return this.discription;
    }

    @Override
    public List<DungeonUser> getAuthors() {
	return new ArrayList<DungeonUser>(this.authors);
    }

    @Override
    public List<DungeonUser> getContributors() {
	return new ArrayList<DungeonUser>(this.contributors);
    }
    
}