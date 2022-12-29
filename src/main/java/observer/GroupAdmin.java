package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    ArrayList<Member> members = new ArrayList<Member>();
    UndoableStringBuilder USB = new UndoableStringBuilder();
    int count = 0;

    /**
     * Constructors
     */
    public GroupAdmin() {
        this.USB = new UndoableStringBuilder();
        this.members = new ArrayList<Member>();
    }

    public GroupAdmin(UndoableStringBuilder usb, ArrayList<Member> members) {
        this.USB = usb;
        this.members = members;
        count = members.size();
    }


    /**
     * A function that add new Member
     *
     * @param obj - Member object
     */
    @Override
    public void register(Member obj) {
        if (!members.contains(obj)) {
            members.add(obj);
            count++;
        } else {
            System.out.println("Member is already registered");
        }

    }

    /**
     * A function that delete Member
     *
     * @param obj - Member object
     */

    @Override
    public void unregister(Member obj) {
        if (members.contains(obj)) {
            members.remove(obj);
            count--;
        } else {
            System.out.println("Member is not registered in this GroupAdmin");
        }

    }

    /**
     * A function that inserts the string into this character sequence
     * Updates all the Members
     *
     * @param offset - int object
     * @param obj    - String object
     */

    @Override
    public void insert(int offset, String obj) {
        USB.insert(offset, obj);
        for (Member member : members) {
            member.update(USB);
        }
    }

    /**
     * A function that appends the given string to this character sequence
     * Updates all the Members
     *
     * @param obj - String object
     */

    @Override
    public void append(String obj) {
        USB.append(obj);
        for (Member member : members) {
            member.update(USB);
        }
    }

    /**
     * A function that erase the sequence between the received indexes
     * Updates all the Members
     *
     * @param start - int object.
     * @param end   - int object.
     */
    @Override
    public void delete(int start, int end) {
        USB.delete(start, end);
        for (Member member : members) {
            member.update(USB);
        }
    }

    /**
     * Undoes the last operation
     * Updates all the Members
     */
    @Override
    public void undo() {
        USB.undo();
        for (Member member : members) {
            member.update(USB);
        }


    }

    /**
     * @return: members list
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * @return: USB
     */
    public UndoableStringBuilder getUSB() {
        return USB;
    }

    public Member getLast() {
        if (!this.members.isEmpty()) {
            return this.members.get(count - 1);
        } else {
            return null;
        }
    }

    /**
     * A toString method
     *
     * @return
     */
    @Override
    public String toString() {
        return members.toString();
    }
}
