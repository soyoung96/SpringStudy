package Hello.core.member;

public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemberMemoryRepository(); // 추상화에도 의존하고, 구체화에도 의존함-> 나쁜 코드드
    private final MemberRepository memberRepository;//이제 추상화에만 의존함 DIP자캄

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
