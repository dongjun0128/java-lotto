package lotto;

import lotto.domain.Computer;
import lotto.domain.LottoProcess;
import lotto.domain.User;

import java.util.List;

public class LottoController {
    User user = new User();
    Computer computer = new Computer();
    LottoProcess lottoProcess;

    public void start(){
        List<List<Integer>> lottos = inputProcess();
        List<Integer> ranks;

        lottoProcess = new LottoProcess(lottos, user.getWinningNumbers(), user.getBonusNumber(), user.getMoney());
        ranks = lottoProcess.decideRanks(lottos, user.getWinningNumbers());
        lottoProcess.printStatistics(lottoProcess.countRanks(ranks));
        lottoProcess.calculateRateOfReturn(lottoProcess.countRanks(ranks));
    }

    private List<List<Integer>> inputProcess(){
        List<List<Integer>> lottos;

        user.inputMoney();
        lottos = computer.createLottos(user.getMoney());
        computer.printLottos(lottos);
        user.inputWinningNumbers();
        user.inputBonusNumber();

        return lottos;
    }
}
