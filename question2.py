def gas_station(gas:list, cost:list)-> int:
    totalCost = 0
    gasVolume = 0
    tankStats=0
    dataIndex=0

    for k in range(len(gas)):
        gasVolume+=gas[k];
        totalCost+=cost[k];
        tankStats+=gas[k]-cost[k];
    
        if tankStats<0:
            dataIndex=k+1
            tankStats = 0

    #if we can finish the circuit return index number else return -1
    return dataIndex if gasVolume>=totalCost else -1

print (gas_station([1,2,3,4,5],[3,5,4,1,2]))
print (gas_station([2,3,4],[3,4,3]))
